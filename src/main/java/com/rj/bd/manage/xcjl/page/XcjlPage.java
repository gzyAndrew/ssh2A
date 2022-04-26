package com.rj.bd.manage.xcjl.page;

import com.rj.bd.framework.page.BasicPage;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class XcjlPage extends BasicPage {

    public String name;
    public int Moneymax;
    public int Moneymin;
    public String Datamax;
    public String Datamin;

    @Override
    public void addParameter() {
        System.out.println("XcjlPage()   ---- >  分页，且传回来的名字为" + name);
        super.setPageSize(2);
        String hql = "from com.rj.bd.entity.YxglXuanchuangjilu";

        if (name != null && name.trim().length() > 0) {
            hql = hql + " where yxglXuanchuangfangshi.xcfsName like ? ";
            this.addParams(Types.VARCHAR, "%" + name.trim() + "%");
        }else{
            hql = hql + " where yxglXuanchuangfangshi.xcfsName like ? ";
            this.addParams(Types.VARCHAR, "%%");
        }

        if (Moneymin >= 0) {
            hql = hql + " and xcjlTotal > ? ";
            this.addParams(Types.INTEGER, Moneymin);
        }

        if (Moneymax > Moneymin) {
            hql = hql + " and xcjlTotal < ? ";
            this.addParams(Types.INTEGER, Moneymax);
        }

        System.out.println(Datamin);

        if (Datamin != null && Datamin.trim().length() > 0) {
            hql = hql + " and xcjlDate > ?  ";
                this.addParams(Types.VARCHAR,Datamin);
        }

        if (Datamax != null && Datamax.trim().length() > 0) {
            hql = hql + " and xcjlDate < ? ";
            this.addParams(Types.VARCHAR, Datamax);
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

    public int getMoneymax() {
        return Moneymax;
    }

    public void setMoneymax(int moneymax) {
        Moneymax = moneymax;
    }

    public int getMoneymin() {
        return Moneymin;
    }

    public void setMoneymin(int moneymin) {
        Moneymin = moneymin;
    }

    public String getDatamax() {
        return Datamax;
    }

    public void setDatamax(String datamax) {
        Datamax = datamax;
    }

    public String getDatamin() {
        return Datamin;
    }

    public void setDatamin(String datamin) {
        Datamin = datamin;
    }
}
