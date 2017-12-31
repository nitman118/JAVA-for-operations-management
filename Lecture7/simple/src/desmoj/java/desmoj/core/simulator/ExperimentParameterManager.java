package desmoj.core.simulator;

/**
 * Interface to restrict the functionalities of a parameter-manager
 * to manage experiment-parameters. This Interface should be used as
 * return-type of the Experiment's methods which return the parameter-
 * manager. 
 * 
 * @author Tim Janz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You
 * may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
public interface ExperimentParameterManager
{
	/**
	 * Method assign a value to an experiment-parameter declared
	 * previously by calling the model's parameter-manager method
	 * to declare an experiment-parameter
	 * 
	 * @param name
	 * 			the parameter's name
	 * @param value
	 * 			the parameter's value
	 */
    public void assignExperimentParameter(String name, Object value);
}
