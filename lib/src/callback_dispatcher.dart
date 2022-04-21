import 'dart:ui';

import 'package:flutter/cupertino.dart';
import 'package:flutter/services.dart';

void callbackDispatcher() {
  const MethodChannel _backgroundChanel = MethodChannel('plugins.flutter.jonthan/background_job');
  WidgetsFlutterBinding.ensureInitialized();

  _backgroundChanel.setMethodCallHandler((MethodCall call) async {
    final List<dynamic> args = call.arguments;
    final Function? callback = PluginUtilities.getCallbackFromHandle(CallbackHandle.fromRawHandle(args[0]));
    assert(callback != null);
    final String messagae = args[1];
    callback!(messagae);
  });

  _backgroundChanel.invokeMethod('BackgroundService.initialized');
}
