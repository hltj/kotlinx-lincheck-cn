package com.devexperts.dxlab.lincheck.execution;

/*
 * #%L
 * Lincheck
 * %%
 * Copyright (C) 2015 - 2018 Devexperts, LLC
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import com.devexperts.dxlab.lincheck.Actor;
import com.devexperts.dxlab.lincheck.strategy.Strategy;

import java.util.List;

/**
 * This class represents an execution scenario, which
 * is generated by an {@link ExecutionGenerator} and then \
 * used by a {@link Strategy} which produces an {@link ExecutionResult}.
 */
public class ExecutionScenario {
    /**
     * The initial sequential part of the execution.
     * It helps to produce different initial states
     * before the parallel part.
     */
    public final List<Actor> initExecution;
    /**
     * The parallel part of the execution, which is used
     * to find an interleaving with incorrect behaviour.
     */
    public final List<List<Actor>> parallelExecution;
    /**
     * The last sequential part is used to test that
     * the data structure is in a correct state.
     */
    public final List<Actor> postExecution;

    public ExecutionScenario(List<Actor> initExecution, List<List<Actor>> parallelExecution, List<Actor> postExecution) {
        this.initExecution = initExecution;
        this.parallelExecution = parallelExecution;
        this.postExecution = postExecution;
    }

    /**
     * Returns the number of threads used in
     * the parallel part of this execution.
     */
    public int getThreads() {
        return parallelExecution.size();
    }
}