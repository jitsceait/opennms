/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2007-2014 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2014 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.sms.main;

import org.opennms.sms.ping.SmsPinger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main
 *
 * @author brozow
 * @version $Id: $
 */
public abstract class Main {

    /**
     * <p>main</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     * @throws java.lang.InterruptedException if any.
     * @throws java.lang.Exception if any.
     */
    public static void main(String[] args) throws InterruptedException, Exception {
        String[] contextFiles = new String[] {
                "classpath*:/META-INF/spring/bundle-context.xml",
                "classpath*:/META-INF/opennms/bundle-context-opennms.xml",
        };
        
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(contextFiles);
        appContext.registerShutdownHook();
        
        Long latency = SmsPinger.ping("+19193602380");
        
        System.err.println(String.format("Latency is %d", latency));
        
        System.exit(0);
    }

}
