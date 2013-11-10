package de.mageis.xposedfitbitsync;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class OverrideDeviceDetection implements IXposedHookLoadPackage {
  public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
    if (lpparam.packageName.equals("com.fitbit.FitbitMobile")) {
      //XposedBridge.log("we are in FitbitMobile!");

      findAndHookMethod("com.fitbit.bluetooth.a", lpparam.classLoader, "e", XC_MethodReplacement.returnConstant(true));
    }
  }
}


