package com.zhang.biyeseji.remeberme.pojo;

import java.util.ArrayList;
import java.util.List;

public class PermsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermsExample() {
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

        public Criteria andPermsidIsNull() {
            addCriterion("permsid is null");
            return (Criteria) this;
        }

        public Criteria andPermsidIsNotNull() {
            addCriterion("permsid is not null");
            return (Criteria) this;
        }

        public Criteria andPermsidEqualTo(Integer value) {
            addCriterion("permsid =", value, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidNotEqualTo(Integer value) {
            addCriterion("permsid <>", value, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidGreaterThan(Integer value) {
            addCriterion("permsid >", value, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("permsid >=", value, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidLessThan(Integer value) {
            addCriterion("permsid <", value, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidLessThanOrEqualTo(Integer value) {
            addCriterion("permsid <=", value, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidIn(List<Integer> values) {
            addCriterion("permsid in", values, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidNotIn(List<Integer> values) {
            addCriterion("permsid not in", values, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidBetween(Integer value1, Integer value2) {
            addCriterion("permsid between", value1, value2, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsidNotBetween(Integer value1, Integer value2) {
            addCriterion("permsid not between", value1, value2, "permsid");
            return (Criteria) this;
        }

        public Criteria andPermsnameIsNull() {
            addCriterion("permsname is null");
            return (Criteria) this;
        }

        public Criteria andPermsnameIsNotNull() {
            addCriterion("permsname is not null");
            return (Criteria) this;
        }

        public Criteria andPermsnameEqualTo(String value) {
            addCriterion("permsname =", value, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameNotEqualTo(String value) {
            addCriterion("permsname <>", value, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameGreaterThan(String value) {
            addCriterion("permsname >", value, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameGreaterThanOrEqualTo(String value) {
            addCriterion("permsname >=", value, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameLessThan(String value) {
            addCriterion("permsname <", value, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameLessThanOrEqualTo(String value) {
            addCriterion("permsname <=", value, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameLike(String value) {
            addCriterion("permsname like", value, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameNotLike(String value) {
            addCriterion("permsname not like", value, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameIn(List<String> values) {
            addCriterion("permsname in", values, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameNotIn(List<String> values) {
            addCriterion("permsname not in", values, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameBetween(String value1, String value2) {
            addCriterion("permsname between", value1, value2, "permsname");
            return (Criteria) this;
        }

        public Criteria andPermsnameNotBetween(String value1, String value2) {
            addCriterion("permsname not between", value1, value2, "permsname");
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