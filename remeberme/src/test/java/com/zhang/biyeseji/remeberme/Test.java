package com.zhang.biyeseji.remeberme;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zhang.biyeseji.remeberme.config.Es;
import com.zhang.biyeseji.remeberme.mapper.BlogMapper;
import com.zhang.biyeseji.remeberme.mapper.UseryonghuMapper;
import com.zhang.biyeseji.remeberme.pojo.Blog;
import com.zhang.biyeseji.remeberme.pojo.Blogclassfiy;
import com.zhang.biyeseji.remeberme.pojo.Blogtags;
import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import com.zhang.biyeseji.remeberme.service.EsClientService;
import com.zhang.biyeseji.remeberme.util.JWTService;
import org.apache.catalina.User;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    JWTService jwtService;
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Autowired
    UseryonghuMapper useryonghuMapper;
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    EsClientService esClientService;
    @org.junit.Test
    public void nihao(){
        Map<String,String> map=new HashMap<>();
        map.put("name","张永田");
        String token=jwtService.setInfoToGetToken(map,"nihao");
        System.out.println(token);
        DecodedJWT decodedJWT=jwtService.fromTokenGetInfo(token,"nihao");
        System.out.println(decodedJWT.getClaim("name").asString());
    }

    //测试es
    @org.junit.Test
    public void test() throws IOException {
        IndexRequest indexRequest=new IndexRequest("blog");
        indexRequest.id("1");
        Blog blog=blogMapper.selectByPrimaryKey(2);
        System.out.println(blog);
        List<Blogclassfiy> classfiys=blogMapper.selectClassfiysByblogId(blog.getId());
        blog.setBlogclassfiys(classfiys);
        List<Blogtags> blogtags=blogMapper.selectTagsByblogId(blog.getId());
        blog.setBlogtags(blogtags);
        Useryonghu useryonghu=useryonghuMapper.selectByPrimaryKey(blog.getUserid());
        useryonghu.setUserpassword(null);
        blog.setUseryonghu(useryonghu);
        blog.setContent("null");
        String blogjson= JSON.toJSONString(blog);
        System.out.println(blogjson);
        indexRequest.source(blogjson, XContentType.JSON);
        IndexResponse indexResponse=  restHighLevelClient.index(indexRequest,Es.COMMON_OPTIONS);
        System.out.println(indexResponse);
        restHighLevelClient.close();
    }

    //获取数据
    @org.junit.Test
    public void tests() throws IOException {
        //创建搜索请求
        SearchRequest searchRequest = new SearchRequest("blog");
        //构造搜索参数
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //设置需要精确查询的字段
        BoolQueryBuilder boolQueryBuilder=QueryBuilders.boolQuery();
        boolQueryBuilder.should(QueryBuilders.matchQuery("introduce","发不知道"));
        boolQueryBuilder.should(QueryBuilders.matchQuery("title","斯"));
        searchSourceBuilder.query(boolQueryBuilder);
        searchSourceBuilder.from((1 - 1) * 1);
        searchSourceBuilder.size(1);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        //高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        //设置高亮字段
        highlightBuilder.field("introduce");
        highlightBuilder.field("title");
        //如果要多个字段高亮,这项要为false
        highlightBuilder.requireFieldMatch(false);
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");

        //下面这两项,如果你要高亮如文字内容等有很多字的字段,必须配置,不然会导致高亮不全,文章内容缺失等
        highlightBuilder.fragmentSize(800000); //最大高亮分片数
        highlightBuilder.numOfFragments(0); //从第一个分片获取高亮片段
        searchSourceBuilder.highlighter(highlightBuilder);

        searchRequest.source(searchSourceBuilder);
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        System.out.println(response);
        List<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit hit : response.getHits().getHits()) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            //解析高亮字段
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField field= highlightFields.get("introduce");
            HighlightField field1= highlightFields.get("title");
            if(field!= null){
                Text[] fragments = field.fragments();
                String n_field = "";
                for (Text fragment : fragments) {
                    n_field += fragment;
                }
                //高亮标题覆盖原标题
                sourceAsMap.put("introduce",n_field);
            }
            if(field1!= null){
                Text[] fragments = field1.fragments();
                String n_field = "";
                for (Text fragment : fragments) {
                    n_field += fragment;
                }
                //高亮标题覆盖原标题
                sourceAsMap.put("title",n_field);
            }
            list.add(hit.getSourceAsMap());
        }
        System.out.println(list);
    }
    @org.junit.Test
    public void testnihao() throws IOException {
//        Blog blog=new Blog();
//        blog.setId(4);
//        esClientService.saveToEs(blog);
//        Map<String,String> field=new HashMap<>();
//        field.put("introduce","发不知道");
//        field.put("title","斯");
//        List<Map<String, Object>> list=esClientService.getBlogFromEsByPageRequest(field,1,1,"blog");
//        System.out.println(list);
//
//        DeleteRequest request = new DeleteRequest(
//                "blog",
//                "54");
//        restHighLevelClient.delete(request,RequestOptions.DEFAULT);
//        redisTemplate.opsForValue().set("nihao","jiushi");
        int nihao=(int)(Math.random()*10);
        redisTemplate.expire("this.id",nihao,TimeUnit.SECONDS);

        System.out.println(nihao);
    }

}
