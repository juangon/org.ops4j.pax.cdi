/*
 * Copyright 2012 Harald Wellmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.cdi.tck.porting.owb;

import javax.enterprise.inject.spi.BeanManager;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.container.InjectableBeanManager;
import org.jboss.jsr299.tck.spi.Managers;

public class ManagersImpl implements Managers {

    private static volatile InjectableBeanManager beanManager;

    public static void cleanUp() {
        beanManager = null;
    }

    public BeanManager getManager() {
        if (beanManager == null) {
            beanManager = new InjectableBeanManager(WebBeansContext.getInstance()
                .getBeanManagerImpl());
        }

        return beanManager;
    }
}
