package com.zhang.biyeseji.remeberme.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserorginExample  implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserorginExample() {
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

        public Criteria andUserorginidIsNull() {
            addCriterion("userorginid is null");
            return (Criteria) this;
        }

        public Criteria andUserorginidIsNotNull() {
            addCriterion("userorginid is not null");
            return (Criteria) this;
        }

        public Criteria andUserorginidEqualTo(Integer value) {
            addCriterion("userorginid =", value, "userorginid");
            return (Criteria) this;
        }

        public Criteria andUserorginidNotEqualTo(Integer value) {
            addCriterion("userorginid <>", value, "userorginid");
            return (Criteria) this;
        }

        public Criteria andUserorginidGreaterThan(Integer value) {
            addCriterion("userorginid >", value, "userorginid");
            return (Criteria) this;
        }

        public Criteria andUserorginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userorginid >=", value, "userorginid");
            return (Criteria) this;
        }

        public Criteria andUserorginidLessThan(Integer value) {
            addCriterion("userorginid <", value, "userorginid");
            return (Criteria) this;
        }

        public Criteria andUserorginidLessThanOrEqualTo(Integer value) {
            addCriterion("userorginid <=", value, "userorginid");
            return (Criteria) this;
        }

        public Criteria andUserorginidIn(List<Integer> values) {
            addCriterion("userorginid in", values, "userorginid");
            return (Criteria) this;
        }

        public Criteria andUserorginidNotIn(List<Integer> values) {
            addCriterion("userorginid not in", values, "userorginid");
            return (Criteria) this;
        }

        public Criteria andUserorginidBetween(Integer value1, Integer value2) {
            addCriterion("userorginid between", value1, value2, "userorginid");
            return (Criteria) this;
        }

        public Criteria andUserorginidNotBetween(Integer value1, Integer value2) {
            addCriterion("userorginid not between", value1, value2, "userorginid");
            return (Criteria) this;
        }

        public Criteria andUserorgincountIsNull() {
            addCriterion("userorgincount is null");
            return (Criteria) this;
        }

        public Criteria andUserorgincountIsNotNull() {
            addCriterion("userorgincount is not null");
            return (Criteria) this;
        }

        public Criteria andUserorgincountEqualTo(Integer value) {
            addCriterion("userorgincount =", value, "userorgincount");
            return (Criteria) this;
        }

        public Criteria andUserorgincountNotEqualTo(Integer value) {
            addCriterion("userorgincount <>", value, "userorgincount");
            return (Criteria) this;
        }

        public Criteria andUserorgincountGreaterThan(Integer value) {
            addCriterion("userorgincount >", value, "userorgincount");
            return (Criteria) this;
        }

        public Criteria andUserorgincountGreaterThanOrEqualTo(Integer value) {
            addCriterion("userorgincount >=", value, "userorgincount");
            return (Criteria) this;
        }

        public Criteria andUserorgincountLessThan(Integer value) {
            addCriterion("userorgincount <", value, "userorgincount");
            return (Criteria) this;
        }

        public Criteria andUserorgincountLessThanOrEqualTo(Integer value) {
            addCriterion("userorgincount <=", value, "userorgincount");
            return (Criteria) this;
        }

        public Criteria andUserorgincountIn(List<Integer> values) {
            addCriterion("userorgincount in", values, "userorgincount");
            return (Criteria) this;
        }

        public Criteria andUserorgincountNotIn(List<Integer> values) {
            addCriterion("userorgincount not in", values, "userorgincount");
            return (Criteria) this;
        }

        public Criteria andUserorgincountBetween(Integer value1, Integer value2) {
            addCriterion("userorgincount between", value1, value2, "userorgincount");
            return (Criteria) this;
        }

        public Criteria andUserorgincountNotBetween(Integer value1, Integer value2) {
            addCriterion("userorgincount not between", value1, value2, "userorgincount");
            return (Criteria) this;
        }

        public Criteria andUseroriginnameIsNull() {
            addCriterion("useroriginname is null");
            return (Criteria) this;
        }

        public Criteria andUseroriginnameIsNotNull() {
            addCriterion("useroriginname is not null");
            return (Criteria) this;
        }

        public Criteria andUseroriginnameEqualTo(String value) {
            addCriterion("useroriginname =", value, "useroriginname");
            return (Criteria) this;
        }

        public Criteria andUseroriginnameNotEqualTo(String value) {
            addCriterion("useroriginname <>", value, "useroriginname");
            return (Criteria) this;
        }

        public Criteria andUseroriginnameGreaterThan(String value) {
            addCriterion("useroriginname >", value, "useroriginname");
            return (Criteria) this;
        }

        public Criteria andUseroriginnameGreaterThanOrEqualTo(String value) {
            addCriterion("useroriginname >=", value, "useroriginname");
            return (Criteria) this;
        }

        public Criteria andUseroriginnameLessThan(String value) {
            addCriterion("useroriginname <", value, "useroriginname");
            return (Criteria) this;
        }

        public Criteria andUseroriginnameLessThanOrEqualTo(String value) {
            addCriterion("useroriginname <=", value, "useroriginname");
            return (Criteria) this;
        }

        public Criteria andUseroriginnameLike(String value) {
            addCriterion("useroriginname like", value, "useroriginname");
            return (Criteria) this;
        }

        public Criteria andUseroriginnameNotLike(String value) {
            addCriterion("useroriginname not like", value, "useroriginname");
            return (Criteria) this;
        }

        public Criteria andUseroriginnameIn(List<String> values) {
            addCriterion("useroriginname in", values, "useroriginname");
            return (Criteria) this;
        }

        public Criteria andUseroriginnameNotIn(List<String> values) {
            addCriterion("useroriginname not in", values, "useroriginname");
            return (Criteria) this;
        }

        public Criteria andUseroriginnameBetween(String value1, String value2) {
            addCriterion("useroriginname between", value1, value2, "useroriginname");
            return (Criteria) this;
        }

        public Criteria andUseroriginnameNotBetween(String value1, String value2) {
            addCriterion("useroriginname not between", value1, value2, "useroriginname");
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