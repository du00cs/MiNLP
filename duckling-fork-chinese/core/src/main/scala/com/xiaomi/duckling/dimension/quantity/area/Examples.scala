/*
 * Copyright (c) 2020, Xiaomi and/or its affiliates. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xiaomi.duckling.dimension.quantity.area

import com.xiaomi.duckling.Types
import com.xiaomi.duckling.dimension.DimExamples
import com.xiaomi.duckling.dimension.quantity.QuantityValue

trait Examples extends DimExamples {
  override def pairs: List[(Types.ResolvedValue, List[String])] = List(
    (QuantityValue(3, "平方米", "Area"), List("三平方", "三平方米", "三个平方", "三平米", "三平")),
    (QuantityValue(3, "平方千米", "Area"), List("三平方千米", "三平方公里"))
  )
}
