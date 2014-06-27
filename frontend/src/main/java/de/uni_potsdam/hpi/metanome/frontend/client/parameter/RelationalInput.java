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


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import de.uni_potsdam.hpi.metanome.algorithm_integration.AlgorithmConfigurationException;
import de.uni_potsdam.hpi.metanome.algorithm_integration.configuration.ConfigurationSettingCsvFile;
import de.uni_potsdam.hpi.metanome.algorithm_integration.configuration.ConfigurationSettingDataSource;
import de.uni_potsdam.hpi.metanome.algorithm_integration.configuration.ConfigurationSettingSqlIterator;
import de.uni_potsdam.hpi.metanome.frontend.client.helpers.InputValidationException;

/**
 * A wrapper for an input. The input can be an csv file or a database connection.
 *
 * @author Tanja
 */
public class RelationalInput extends InputField {

	HorizontalPanel content;
	Button sqlButton;
	Button csvButton;
	SqlIteratorInput sqlInput;
	CsvFileInput csvInput;

	/**
	 * @param optional If true, a remove button will be rendered, to remove this widget from its parent.
	 */
	public RelationalInput(boolean optional) {
		super(optional);

		this.sqlInput = new SqlIteratorInput(false);
		this.csvInput = new CsvFileInput(false);
		this.content = new HorizontalPanel();

		this.sqlButton = new Button("Database Connection", new ClickHandler() {
			public void onClick(ClickEvent event) {
				content.clear();
				content.add(sqlInput);
			}
		});
		this.csvButton = new Button("CSV File", new ClickHandler() {
			public void onClick(ClickEvent event) {
				content.clear();
				content.add(csvInput);
			}
		});

		VerticalPanel wrapper = new VerticalPanel();
		HorizontalPanel buttonWrapper = new HorizontalPanel();
		SimplePanel contentWrapper = new SimplePanel();
		wrapper.add(buttonWrapper);
		wrapper.add(contentWrapper);
		this.add(wrapper);

		buttonWrapper.add(this.sqlButton);
		buttonWrapper.add(this.csvButton);

		contentWrapper.add(this.content);
		this.content.add(sqlInput);
	}

	public void addCsvFiles(String[] files) throws AlgorithmConfigurationException {
		this.csvInput.addToListbox(files);
	}

	/**
	 * Depending on which input is selected, the getValue function of the specific input is called and the
	 * corresponding ConfigurationSetting is returned.
	 *
	 * @return the setting of the chosen input
	 * @throws de.uni_potsdam.hpi.metanome.frontend.client.helpers.InputValidationException
	 */
	public ConfigurationSettingDataSource getValue() throws InputValidationException {
		Widget currentInput = this.content.getWidget(0);

		if (currentInput.getClass() == SqlIteratorInput.class) {
			return ((SqlIteratorInput) currentInput).getValue();
		} else if (currentInput.getClass() == CsvFileInput.class) {
			return ((CsvFileInput) currentInput).getValuesAsSettings();
		}

		throw new InputValidationException("Input not supported!");
	}

	/**
	 * Depending on the type of the ConfigurationSetting, the setValue method of the corresponding input is called.
	 *
	 * @param setting The setting which should be set.
	 * @throws AlgorithmConfigurationException
	 */
	public void setValues(ConfigurationSettingDataSource setting) throws AlgorithmConfigurationException {
		if (setting instanceof ConfigurationSettingSqlIterator)
			this.sqlInput.setValues((ConfigurationSettingSqlIterator) setting);
		else if (setting instanceof ConfigurationSettingCsvFile)
			this.csvInput.selectDataSource(setting);
	}
}
