package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BlogclassfiyExample  implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogclassfiyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andClassfiyidIsNull() {
            addCriterion("classfiyid is null");
            return (Criteria) this;
        }

        public Criteria andClassfiyidIsNotNull() {
            addCriterion("classfiyid is not null");
            return (Criteria) this;
        }

        public Criteria andClassfiyidEqualTo(Integer value) {
            addCriterion("classfiyid =", value, "classfiyid");
            return (Criteria) this;
        }

        public Criteria andClassfiyidNotEqualTo(Integer value) {
            addCriterion("classfiyid <>", value, "classfiyid");
            return (Criteria) this;
        }

        public Criteria andClassfiyidGreaterThan(Integer value) {
            addCriterion("classfiyid >", value, "classfiyid");
            return (Criteria) this;
        }

        public Criteria andClassfiyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("classfiyid >=", value, "classfiyid");
            return (Criteria) this;
        }

        public Criteria andClassfiyidLessThan(Integer value) {
            addCriterion("classfiyid <", value, "classfiyid");
            return (Criteria) this;
        }

        public Criteria andClassfiyidLessThanOrEqualTo(Integer value) {
            addCriterion("classfiyid <=", value, "classfiyid");
            return (Criteria) this;
        }

        public Criteria andClassfiyidIn(List<Integer> values) {
            addCriterion("classfiyid in", values, "classfiyid");
            return (Criteria) this;
        }

        public Criteria andClassfiyidNotIn(List<Integer> values) {
            addCriterion("classfiyid not in", values, "classfiyid");
            return (Criteria) this;
        }

        public Criteria andClassfiyidBetween(Integer value1, Integer value2) {
            addCriterion("classfiyid between", value1, value2, "classfiyid");
            return (Criteria) this;
        }

        public Criteria andClassfiyidNotBetween(Integer value1, Integer value2) {
            addCriterion("classfiyid not between", value1, value2, "classfiyid");
            return (Criteria) this;
        }

        public Criteria andClassfiynameIsNull() {
            addCriterion("classfiyname is null");
            return (Criteria) this;
        }

        public Criteria andClassfiynameIsNotNull() {
            addCriterion("classfiyname is not null");
            return (Criteria) this;
        }

        public Criteria andClassfiynameEqualTo(String value) {
            addCriterion("classfiyname =", value, "classfiyname");
            return (Criteria) this;
        }

        public Criteria andClassfiynameNotEqualTo(String value) {
            addCriterion("classfiyname <>", value, "classfiyname");
            return (Criteria) this;
        }

        public Criteria andClassfiynameGreaterThan(String value) {
            addCriterion("classfiyname >", value, "classfiyname");
            return (Criteria) this;
        }

        public Criteria andClassfiynameGreaterThanOrEqualTo(String value) {
            addCriterion("classfiyname >=", value, "classfiyname");
            return (Criteria) this;
        }

        public Criteria andClassfiynameLessThan(String value) {
            addCriterion("classfiyname <", value, "classfiyname");
            return (Criteria) this;
        }

        public Criteria andClassfiynameLessThanOrEqualTo(String value) {
            addCriterion("classfiyname <=", value, "classfiyname");
            return (Criteria) this;
        }

        public Criteria andClassfiynameLike(String value) {
            addCriterion("classfiyname like", value, "classfiyname");
            return (Criteria) this;
        }

        public Criteria andClassfiynameNotLike(String value) {
            addCriterion("classfiyname not like", value, "classfiyname");
            return (Criteria) this;
        }

        public Criteria andClassfiynameIn(List<String> values) {
            addCriterion("classfiyname in", values, "classfiyname");
            return (Criteria) this;
        }

        public Criteria andClassfiynameNotIn(List<String> values) {
            addCriterion("classfiyname not in", values, "classfiyname");
            return (Criteria) this;
        }

        public Criteria andClassfiynameBetween(String value1, String value2) {
            addCriterion("classfiyname between", value1, value2, "classfiyname");
            return (Criteria) this;
        }

        public Criteria andClassfiynameNotBetween(String value1, String value2) {
            addCriterion("classfiyname not between", value1, value2, "classfiyname");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}