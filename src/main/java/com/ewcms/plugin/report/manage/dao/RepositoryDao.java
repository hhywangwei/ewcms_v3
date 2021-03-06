/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */
package com.ewcms.plugin.report.manage.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ewcms.plugin.report.model.Repository;

/**
 * 
 * @author wu_zhijun
 *
 */
public interface RepositoryDao extends PagingAndSortingRepository<Repository, Long>, JpaSpecificationExecutor<Repository> {
}
