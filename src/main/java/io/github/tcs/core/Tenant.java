/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.tcs.core;

import java.util.Objects;

/**
 * The tenant.
 *
 * @author wbiller
 */
public class Tenant {


  /* constants **********************************************************************************************************************************************/

  private static final String TENANT_NAME_REGEXP = "[a-z_]([-_]?[a-z0-9]+)*";


  /* members ************************************************************************************************************************************************/

  private final String name;


  /* constructors *******************************************************************************************************************************************/

  protected Tenant(String name) {

    if (null == name || "".equals(name)) {
      throw new IllegalArgumentException("Name must not be empty");
    }

    if (!name.matches(TENANT_NAME_REGEXP)) {
      throw new IllegalArgumentException(
        "Name must start with a letter or an underscore and only may contain lower case letters, digits, dashes and underscores");
    }

    this.name = name;
  }


  /* methods ************************************************************************************************************************************************/

  @Override
  public String toString() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Tenant tenant = (Tenant) o;
    return name.equals(tenant.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }


  /* factory methods ****************************************************************************************************************************************/

  /**
   * Creates a new tenant with the given name.
   * The name must either start with a lower case letter or an underscore and
   * may contain lower case letters, digits, dashes and underscores.
   *
   * @param name the name of the tenant
   * @return a tenant
   */
  public static Tenant of(String name) {
    return new Tenant(name);
  }
}
