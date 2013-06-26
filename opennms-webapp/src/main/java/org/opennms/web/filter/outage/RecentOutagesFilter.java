/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2009-2012 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2012 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.web.filter.outage;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.opennms.web.filter.OneArgFilter;

/**
 * <p>RecentOutagesFilter class.</p>
 *
 * @author brozow
 * @version $Id: $
 * @since 1.8.1
 */
public class RecentOutagesFilter extends OneArgFilter<Date> {
    /** Constant <code>TYPE="recent"</code> */
    public static final String TYPE = "recent";
    
    /**
     * <p>Constructor for RecentOutagesFilter.</p>
     */
    public RecentOutagesFilter() {
        this(yesterday());
    }
    
    /**
     * <p>Constructor for RecentOutagesFilter.</p>
     *
     * @param since a {@link java.util.Date} object.
     */
    public RecentOutagesFilter(Date since) {
        super(TYPE, "ifRegainedService", since);
    }

    /** {@inheritDoc} */
    @Override
    public String getTextDescription() {
        return "outage since " + getValue();
    }
    
    /**
     * <p>yesterday</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public static Date yesterday() {
        Calendar cal = new GregorianCalendar();
        cal.add( Calendar.DATE, -1 );
        return cal.getTime();
    }

}