/*
 * Copyright 2015 by the Metanome project
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

package de.metanome.backend.result_postprocessing.result_analyzer;

import de.metanome.algorithm_integration.input.RelationalInputGenerator;
import de.metanome.algorithm_integration.results.FunctionalDependency;

import java.util.List;

/**
 * Analyzes Functional Dependency Results.
 */
public class FunctionalDependencyResultAnalyzer extends ResultAnalyzer<FunctionalDependency> {

  public FunctionalDependencyResultAnalyzer(List<RelationalInputGenerator> inputGenerators,
                                           boolean useDataDependentStatistics) {
    super(inputGenerators, useDataDependentStatistics);
  }

  @Override
  protected void analyzeResultsDataIndependent(List<FunctionalDependency> results) {

  }

  @Override
  protected void analyzeResultsDataDependent(List<FunctionalDependency> results) {

  }

  @Override
  public void printResultsToFile() {

  }


}
