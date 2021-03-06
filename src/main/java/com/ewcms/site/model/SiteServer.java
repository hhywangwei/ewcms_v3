/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */

/**
 * 
 */
package com.ewcms.site.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <ul>
 * <li>id:编号</li>
 * <li>path:发布路径</li>
 * <li>hostName:服务器IP</li>
 * <li>port: 端口</li>
 * <li>userName:用户</li>
 * <li>password:密码</li>
 * </ul>
 * 
 * @author 周冬初
 */
@Entity
@Table(name = "site_siteserver")
@SequenceGenerator(name = "seq_site_siteserver", sequenceName = "seq_site_siteserver_id", allocationSize = 1)
public class SiteServer implements Serializable {

	private static final long serialVersionUID = -1138195790814414334L;

	@Id
	@GeneratedValue(generator = "seq_site_siteserver", strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(length = 100)
	private String path;
	@Column(length = 20)
	private String hostName;
	@Column(length = 5)
	private String port;
	@Column(length = 30)
	private String userName;
	@Column(length = 20)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String user) {
		this.userName = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
