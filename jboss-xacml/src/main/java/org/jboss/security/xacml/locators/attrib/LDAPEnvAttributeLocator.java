/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors. 
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.security.xacml.locators.attrib;

import java.net.URI;
import java.net.URISyntaxException;

import org.jboss.security.xacml.sunxacml.EvaluationCtx;
import org.jboss.security.xacml.sunxacml.cond.EvaluationResult;

/**
 * LDAP Attribute Locator that will get an environment attribute
 * @author Anil.Saldhana@redhat.com
 * @since Aug 25, 2010
 */
public class LDAPEnvAttributeLocator extends LDAPAttributeLocator
{    
   @Override
   protected Object getSubstituteValue(URI attributeType, EvaluationCtx context) throws URISyntaxException
   {
      EvaluationResult evalResult = context.getEnvironmentAttribute( new URI( dataTypeOfSubstituteValue ), 
               new URI( substituteValue ), null);
      
      return this.getAttributeValue( evalResult, attributeType ); 
   }
}