// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

package com.microsoft.accessibilityinsightsforandroidservice;

import com.deque.axe.android.Axe;
import com.deque.axe.android.AxeConf;
import com.deque.axe.android.constants.AxeStandard;
import com.deque.axe.android.rules.hierarchy.TouchSizeWcag;

public class AxeRunnerFactory {
    public Axe createAxeRunner() {
        AxeConf axeConf = new AxeConf();
        axeConf.removeStandard(AxeStandard.BEST_PRACTICE);
        axeConf.removeStandard(AxeStandard.PLATFORM);
        axeConf.ignore(TouchSizeWcag.class.getSimpleName(), true);
        return new Axe(axeConf);
    }
}
