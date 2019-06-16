package com.bdqn.dao;

import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * Created by zezhong.shang on 16-1-15.
 */
public abstract class AbstractRepository<T> {

    private MongoTemplate mongoTemplate;
    /**
     * <b>function:</b>添加对象
     *
     * @author cuiran
     * @createDate 2012-12-12 11:41:30
     */
    public void insert(T t) {
        mongoTemplate.insert(t);
    }
    /**
     * <b>function:</b>根据ID查找对象
     *
     * @author cuiran
     * @createDate 2012-12-12 11:41:41
     */
    public T findOne(String id) {
        return mongoTemplate.findById(id,this.getEntityClass());
    }
    /**
     * <b>function:</b>查询所有
     *
     * @author cuiran
     * @createDate 2012-12-12 16:26:06
     */
    public List<T> findAll() {
        return mongoTemplate.find(new Query(), this.getEntityClass());
    }
    /**
     * <b>function:</b>删除指定的ID对象
     *
     * @author cuiran
     * @createDate 2012-12-12 16:26:16
     */
    public void removeOne(String id) {
        Criteria criteria = Criteria.where("id").in(id);
        if (criteria == null) {
            Query query = new Query(criteria);
            if (query != null && mongoTemplate.findOne(query, this.getEntityClass()) != null)
                mongoTemplate.remove(mongoTemplate.findOne(query, this.getEntityClass()));
        }
    }
    /**
     * <b>function:</b>删除所有
     *
     * @author cuiran
     * @createDate 2012-12-12 16:25:40
     */
    public void removeAll() {
        mongoTemplate.remove(new Query(), this.getEntityClass());
    }
    /**
     * @param query
     * @return
     */
    public List<T> find(Query query) {
        return mongoTemplate.find(query, this.getEntityClass());
    }

    public List<T> find(Query query,Class type) {
        return mongoTemplate.find(query,type);
    }
    /**
     * 查询分页的数据
     * @param pageNo
     * @param pageSize
     * @param query
     * @return
     */
    public Page<T> queryPage(int pageNo, int pageSize, Query query) {
        if(EmptyUtils.isEmpty(query)){
            query=new Query();
        }

        long totalCount = this.mongoTemplate.count(query, this.getEntityClass());
        Page<T> page = new Page<T>(pageNo,totalCount,new Long(pageSize));
        query.skip(new Long(page.getBeginPos()).intValue());// skip相当于从那条记录开始
        query.limit(pageSize);// 从skip开始,取多少条记录
        List datas = this.find(query,getEntityClass());
        page.setRows(datas);
        return page;
    }
    /**
     * 修改数据库
     */
    public void modify(T t,Update update){
        Query query = new Query();
        query.addCriteria(new Criteria("_id").is(getId(t)));
        this.mongoTemplate.updateFirst(query, update,getEntityClass());
    }
    /**
     *
     * @param query
     * @return
     */
    public T findOne(Query query){
       return  this.mongoTemplate.findOne(query,getEntityClass());
    }

    /***
     * 需要重写的方方
     * @return
     */
    protected abstract Class<T> getEntityClass();
    /***
     * 需要重写的方方
     * @return
     */
    protected abstract String getId(T t);
    /**
     * get set 方法
     *
     * @return
     */
    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

}
