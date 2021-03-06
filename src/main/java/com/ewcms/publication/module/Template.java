/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */

/**
 * 
 */
package com.ewcms.publication.module;

/**
 * 
 * <ul>
 * <li>id:编号</li>
 * <li>channelId:所示频道编号</li>
 * <li>uniquePath:模板唯一路径（FreeMarker模板加载路径）</li>
 * <li>uriPattern:路径模式 /${now?yyyy-MM-dd}/${id}_${page}.html</li>
 * </ul>
 * 
 * @author <a href="hhywangwei@gmail.com">王伟</a>
 */
public class Template {
	
	public enum TemplateType{
		DETAIL,LIST,HOME,OTHER;
	}
	
	private Long id;
	private Long channelId;
	private TemplateType type;
	private String uniquePath;
	private String uriPattern;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	 
	public TemplateType getType() {
		return type;
	}

	public void setType(TemplateType type) {
		this.type = type;
	}

	public String getUniquePath() {
		return uniquePath;
	}

	public void setUniquePath(String uniquePath) {
		this.uniquePath = uniquePath;
	}

	public String getUriPattern() {
		return uriPattern;
	}

	public void setUriPattern(String uriPattern) {
		this.uriPattern = uriPattern;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Template other = (Template) obj;
		if (this.id != other.id
				&& (this.id == null || !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Template [id=");
		builder.append(id);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append(", uniquePath=");
		builder.append(uniquePath);
		builder.append(", type=");
		builder.append(type);
		builder.append(", uriPattern=");
		builder.append(uriPattern);
		builder.append("]");
		return builder.toString();
	}
}
