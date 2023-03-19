import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';
import 'package:flutter_module/pages/simple_page.dart';

import 'pages/main_page.dart';

void main() {
  CustomFlutterBinding();
  runApp(MyApp());
}

class CustomFlutterBinding extends WidgetsFlutterBinding
    with BoostFlutterBinding {}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  Map<String, FlutterBoostRouteFactory> routerMap = {
    '/' :(settings, uniqueId) {
      return null;
    },
    '/mainPage': (settings, uniqueId) {
      return CupertinoPageRoute(
          settings: settings,
          builder: (_) {
            Map<String, dynamic>? map = settings.arguments as Map<String, dynamic>?;
            String data = map?['data'] as String;
            return MainPage(
              title: data,
            );
          });
    },
    '/simplePage': (settings, uniqueId) {
      return CupertinoPageRoute(
          settings: settings,
          builder: (_) {
            Map<String, dynamic>? map = settings.arguments as Map<String, dynamic>?;
            return SimplePage(
              data: map,
            );
          });
    },
  };

  Widget appBuilder(Widget home) {
    return MaterialApp(
      home: home,
      debugShowCheckedModeBanner: true,

      ///必须加上builder参数，否则showDialog等会出问题
      builder: (_, __) {
        return home;
      },
    );
  }

  Route<dynamic>? routeFactory(RouteSettings settings, String? uniqueId) {
    FlutterBoostRouteFactory func = routerMap[settings.name] as FlutterBoostRouteFactory;
    return func(settings, uniqueId);
  }


  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return FlutterBoostApp(
      routeFactory,
      appBuilder: appBuilder,
    );
  }
}
