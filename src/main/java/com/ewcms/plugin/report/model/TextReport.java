/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */
package com.ewcms.plugin.report.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.ewcms.plugin.externalds.model.BaseDs;

/**
 * 报表对象
 * 
 * <ul>
 * <li>id:报表ID</li>
 * <li>name:报表名</li>
 * <li>type:报表类型</li>
 * <li>textEntity:报表实体</li>
 * <li>createDate:创建时间</li>
 * <li>updateDate:更新时间</li>
 * <li>hidden:隐藏</li>
 * <li>remarks:备注</li>
 * <li>parameters:参数列表（与Parameters对象一对多关联）</li>
 * <li>alqcDataSource:连接数据源对象（与AlqcDataSource对象一对一关联）</li>
 * <li>Category:分类列表(与Category对象多对多关联)</li>
 * </ul>
 * 
 * @author 吴智俊
 */
@Entity
@Table(name = "plugin_report_text")
@SequenceGenerator(name = "seq_plugin_report_text", sequenceName = "seq_plugin_report_text_id", allocationSize = 1)
public class TextReport implements Serializable {

    private static final long serialVersionUID = 2289611908936617074L;
    
    /**
     * 文字报表类型枚举
     * @author wuzhijun
     */
    public enum Type {

        HTML("HTML"), PDF("PDF"), XLS("XLS"), RTF("RTF"), XML("XML");
        
        private String description;

        private Type(String description) {
            this.description = description;
        }

        /**
         * 描述状态
         *
         * @return
         */
        public String getDescription() {
            return this.description;
        }
    }
	@Id
    @GeneratedValue(generator = "seq_plugin_report_text",strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
    private Long id;
    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;
    @Column(name = "textentity")
    private byte[] textEntity;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdate", columnDefinition = "Timestamp default CURRENT_DATE", insertable = false, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    @Column(name = "hidden", nullable = false)
    private Boolean hidden = false;
    @Column(name = "remarks",columnDefinition = "text")
    private String remarks;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Parameter.class)
    @JoinColumn(name="text_id")
    @OrderBy("id")
    private Set<Parameter> parameters = new LinkedHashSet<Parameter>();
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER, targetEntity = BaseDs.class)
    @JoinColumn(name = "base_ds_id")
    private BaseDs baseDs = new BaseDs();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JSONField(serialize = false)
    public byte[] getTextEntity() {
        return textEntity;
    }

    public void setTextEntity(byte[] textEntity) {
        this.textEntity = textEntity;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
		return createDate;
	}

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @JSONField(serialize = false)
    public Set<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(Set<Parameter> parameters) {
        this.parameters = parameters;
    }

    @JSONField(serialize = false)
    public BaseDs getBaseDs() {
        return baseDs;
    }

    public void setBaseDs(BaseDs baseDs) {
        this.baseDs = baseDs;
    }

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TextReport other = (TextReport) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }
}
