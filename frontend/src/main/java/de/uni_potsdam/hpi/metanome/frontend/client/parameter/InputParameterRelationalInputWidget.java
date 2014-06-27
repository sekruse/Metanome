/*
 * Copyright 2014 by the Metanome project
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

package de.uni_potsdam.hpi.metanome.frontend.client.parameter;


import de.uni_potsdam.hpi.metanome.algorithm_integration.AlgorithmConfigurationException;
import de.uni_potsdam.hpi.metanome.algorithm_integration.configuration.*;
import de.uni_potsdam.hpi.metanome.frontend.client.helpers.InputValidationException;

import java.util.List;

public class InputParameterRelationalInputWidget extends InputParameterDataSourceWidget {

	protected ConfigurationSpecificationRelationalInput specification;
	protected List<RelationalInput> inputWidgets;

	public InputParameterRelationalInputWidget(ConfigurationSpecificationRelationalInput config) {
		super(config);
	}

	@Override
	protected void addInputField(boolean optional) {
		RelationalInput field = new RelationalInput(optional);
		this.inputWidgets.add(field);
		int index = (this.getWidgetCount() < 1 ? 0 : this.getWidgetCount() - 1);
		this.insert(field, index);
	}

	@Override
	public ConfigurationSpecification getUpdatedSpecification() throws InputValidationException {
		this.specification.setSettings(this.getConfigurationSettings());
		return this.specification;
	}

	protected ConfigurationSettingDataSource[] getConfigurationSettings() throws InputValidationException {
		ConfigurationSettingDataSource[] values = new ConfigurationSettingDataSource[this.inputWidgets.size()];
		int i = 0;
		for (RelationalInput ii : this.inputWidgets) {
			values[i] = ii.getValue();
			i++;
		}
		return values;
	}

	@Override
	public List<? extends InputField> getInputWidgets() { return this.inputWidgets; }

	@Override
	public void setInputWidgets(List<? extends InputField> inputWidgetsList) {
		this.inputWidgets = (List<RelationalInput>) inputWidgetsList;
	}

	@Override
	public ConfigurationSpecification getSpecification() {
		return specification;
	}

	@Override
	public void setSpecification(ConfigurationSpecification config) {
		this.specification = (ConfigurationSpecificationRelationalInput) config;
	}

	@Override
	public boolean accepts(ConfigurationSettingDataSource setting) {
		return setting instanceof ConfigurationSettingSqlIterator || setting instanceof ConfigurationSettingCsvFile;
	}

	@Override
	public void setDataSource(ConfigurationSettingDataSource dataSource) throws AlgorithmConfigurationException {
		if (dataSource instanceof ConfigurationSettingSqlIterator)
			this.inputWidgets.get(0).setValues(dataSource);
		else if (dataSource instanceof ConfigurationSettingCsvFile)
			this.inputWidgets.get(0).setValues(dataSource);
		else
			; //TODO throw some exception
	}
}
