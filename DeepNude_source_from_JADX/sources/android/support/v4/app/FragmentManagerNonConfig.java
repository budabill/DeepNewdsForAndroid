package android.support.v4.app;

import android.arch.lifecycle.C0073s;
import java.util.List;

public class FragmentManagerNonConfig {
    private final List<FragmentManagerNonConfig> mChildNonConfigs;
    private final List<Fragment> mFragments;
    private final List<C0073s> mViewModelStores;

    FragmentManagerNonConfig(List<Fragment> list, List<FragmentManagerNonConfig> list2, List<C0073s> list3) {
        this.mFragments = list;
        this.mChildNonConfigs = list2;
        this.mViewModelStores = list3;
    }

    List<FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    List<Fragment> getFragments() {
        return this.mFragments;
    }

    List<C0073s> getViewModelStores() {
        return this.mViewModelStores;
    }
}
