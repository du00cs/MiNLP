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

package com.xiaomi.duckling.dimension.quantity.distance

import com.xiaomi.duckling.Types._
import com.xiaomi.duckling.dimension.DimRules
import com.xiaomi.duckling.dimension.implicits._
import com.xiaomi.duckling.dimension.matcher.GroupMatch
import com.xiaomi.duckling.dimension.numeral.{Numeral, NumeralData}
import com.xiaomi.duckling.dimension.quantity.QuantityData

trait Rules extends DimRules {

  val dim = "Distance"

  val numberKm = Rule(
    name = "<number> km",
    pattern = List(isDimension(Numeral).predicate, "(?i)千米|米|公里|km".regex),
    prod = tokens {
      case Token(_, NumeralData(value, _, _, _, _, _)) :: Token(_, GroupMatch(s :: _)) :: _ =>
        val v = if (s == "米") value else 1000 * value
        Token(Distance, QuantityData(v, "米", dim))
    }
  )
}
