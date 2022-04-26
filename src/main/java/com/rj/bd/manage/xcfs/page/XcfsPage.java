package com.rj.bd.manage.xcfs.page;

import com.rj.bd.framework.page.BasicPage;
import org.springframework.stereotype.Component;

import java.sql.Types;


@Component
public class XcfsPage extends BasicPage {

    public String name;
    public int max;
    public int min;

    @Override
    public void addParameter() {
        System.out.println("XcfsPage()   ---- >  分页，且传回来的名字为" + name);
        super.setPageSize(2);
        String hql = "from com.rj.bd.entity.YxglXuanchuangfangshi";

        if (name != null && name.trim().length() > 0) {
            hql = hql + " where xcfsName like ? ";
            this.addParams(Types.VARCHAR, "%" + name.trim() + "%");
        }else{
            hql = hql + " where xcfsName like ? ";
            this.addParams(Types.VARCHAR, "%%");
        }

        if (min >= 0) {
            hql = hql + " and xcfsJiage > ? ";
            this.addParams(Types.INTEGER, min);
        }

        if (max > min) {
            hql = hql + " and xcfsJiage < ? ";
            this.addParams(Types.INTEGER, max);
        }

        this.setHQLString(hql);
        this.setHQLCountString(" select count(*)  " + hql);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
