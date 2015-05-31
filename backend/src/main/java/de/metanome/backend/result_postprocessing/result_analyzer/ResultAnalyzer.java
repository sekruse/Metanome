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
import de.metanome.algorithm_integration.results.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * The results of the algorithm are analyzed. Different statistics and metrics are calculated to
 * allow sorting, ordering and filtering.
 */
public abstract class ResultAnalyzer<T extends Result> {

  boolean useDataDependentStatistics = false;
  List<RelationalInputGenerator> inputGenerators = new ArrayList<>();

  public ResultAnalyzer(List<RelationalInputGenerator> inputGenerators,
                        boolean useDataDependentStatistics) {
    this.inputGenerators = inputGenerators;
    this.useDataDependentStatistics = useDataDependentStatistics;
  }

  /**
   * Analyzes the results.
   *
   * @param results Results of the algorithm
   */
  public void analyzeResults(List<T> results) {
    if (useDataDependentStatistics) {
      analyzeResultsDataDependent(results);
    } else {
      analyzeResultsDataIndependent(results);
    }
  }

  /**
   * Analyzes the results without using the raw data from the inputs.
   *
   * @param results Results of the algorithm
   */
  protected abstract void analyzeResultsDataIndependent(List<T> results);

  /**
   * Analyzes the results using the raw data from the inputs.
   *
   * @param results Results of the algorithm
   */
  protected abstract void analyzeResultsDataDependent(List<T> results);

  /**
   * Prints the results of postprocessing to file
   */
  public abstract void printResultsToFile();

}
