/*
 * Copyright (C) 2017 The Android Open Source Project
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

package com.android.settings.vpn2;

import com.android.settings.testutils.SettingsRobolectricTestRunner;
import com.android.settings.TestConfig;
import com.android.settings.wrapper.ConnectivityManagerWrapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link VpnUtils}.
 */
@RunWith(SettingsRobolectricTestRunner.class)
@Config(manifest = TestConfig.MANIFEST_PATH, sdk = TestConfig.SDK_VERSION_O)
public final class VpnUtilsTest {
    @Test
    public void testIsAlwaysOnVpnSet() {
        final ConnectivityManagerWrapper cm = mock(ConnectivityManagerWrapper.class);
        when(cm.getAlwaysOnVpnPackageForUser(0)).thenReturn("com.example.vpn");
        assertThat(VpnUtils.isAlwaysOnVpnSet(cm, 0)).isTrue();

        when(cm.getAlwaysOnVpnPackageForUser(0)).thenReturn(null);
        assertThat(VpnUtils.isAlwaysOnVpnSet(cm, 0)).isFalse();
    }
}
