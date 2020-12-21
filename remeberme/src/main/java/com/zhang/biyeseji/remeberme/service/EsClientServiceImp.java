package com.zhang.biyeseji.remeberme.service;

import com.alibaba.fastjson.JSON;
import com.zhang.biyeseji.remeberme.config.Es;
import com.zhang.biyeseji.remeberme.mapper.BlogMapper;
import com.zhang.biyeseji.remeberme.mapper.UseryonghuMapper;
import com.zhang.biyeseji.remeberme.pojo.Blog;
import com.zhang.biyeseji.remeberme.pojo.Blogclassfiy;
import com.zhang.biyeseji.remeberme.pojo.Blogtags;
import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class EsClientServiceImp implements EsClientService {

    @Autowired
    public RestHighLevelClient restHighLevelClient;
    @Autowired
    BlogMapper blogMapper;

    @Autowired
    UseryonghuMapper useryonghuMapper;

    @Override
    public void saveToEs(Blog blog1) {
        IndexRequest indexRequest=new IndexRequest("blog");
        indexRequest.id(blog1.getId().toString());
        Blog blog=blogMapper.selectByPrimaryKey(blog1.getId());
        List<Blogclassfiy> classfiys=blogMapper.selectClassfiysByblogId(blog.getId());
        blog.setBlogclassfiys(classfiys);
        List<Blogtags> blogtags=blogMapper.selectTagsByblogId(blog.getId());
        blog.setBlogtags(blogtags);
        Useryonghu useryonghu=useryonghuMapper.selectByPrimaryKey(blog.getUserid());
        useryonghu.setUserpassword(null);
        useryonghu.setSalt(null);
        useryonghu.setUserpassword(null);
        blog.setUseryonghu(useryonghu);
        blog.setContent("null");
        String blogjson= JSON.toJSONString(blog);
        indexRequest.source(blogjson, XContentType.JSON);
        IndexResponse indexResponse= null;
        try {
            indexResponse = restHighLevelClient.index(indexRequest, Es.COMMON_OPTIONS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            restHighLevelClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Map<String, Object>> getBlogFromEsByPageRequest(Map<String, String> fieldMap, Integer pageNum, Integer pageSize, String indexs) {
        //创建搜索请求
        SearchRequest searchRequest = new SearchRequest(indexs);
        //构造搜索参数
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //设置需要精确查询的字段
        BoolQueryBuilder boolQueryBuilder= QueryBuilders.boolQuery();
        for(Map.Entry<String, String> field:fieldMap.entrySet()){
            boolQueryBuilder.should(QueryBuilders.matchQuery(field.getKey(),field.getValue()));
        }
        searchSourceBuilder.query(boolQueryBuilder);
        searchSourceBuilder.from((pageNum - 1) * 1);
        searchSourceBuilder.size(pageSize);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        //高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        //设置高亮字段
        for(Map.Entry<String, String> field:fieldMap.entrySet()){
            highlightBuilder.field(field.getKey());
        }
        //如果要多个字段高亮,这项要为false
        highlightBuilder.requireFieldMatch(false);
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");

        //下面这两项,如果你要高亮如文字内容等有很多字的字段,必须配置,不然会导致高亮不全,文章内容缺失等
        highlightBuilder.fragmentSize(800000); //最大高亮分片数
        highlightBuilder.numOfFragments(0); //从第一个分片获取高亮片段
        searchSourceBuilder.highlighter(highlightBuilder);

        searchRequest.source(searchSourceBuilder);
        SearchResponse response = null;
        try {
            response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(response);
        List<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit hit : response.getHits().getHits()) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            //解析高亮字段
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();

            for(Map.Entry<String, String> field:fieldMap.entrySet()){
                HighlightField fields= highlightFields.get(field.getKey());
                if(fields!= null){
                    Text[] fragments = fields.fragments();
                    String n_field = "";
                    for (Text fragment : fragments) {
                        n_field += fragment;
                    }
                    //高亮标题覆盖原标题
                    sourceAsMap.put(field.getKey(),n_field);
                }
            }
            list.add(hit.getSourceAsMap());
        }
        return list;
    }
}
