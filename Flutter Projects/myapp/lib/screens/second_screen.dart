import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:myapp/pages/camera_page.dart';
import 'package:myapp/pages/home_page.dart';
import 'package:myapp/widget/login_button.dart';

import "../globals.dart" as globals;

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  int _currentIndex = 0;
  final List<Widget> _children = [HomePage(), CameraPage()];
  void onTappedBar(int index) {
    setState(() {
      _currentIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    // void clickOnLoginBtn() {
    //   Navigator.of(context)
    //       .pushNamed(globals.test_route, arguments: {"podatak": "nesto"});
    // }

    return Scaffold(
      body: _children[_currentIndex],
      bottomNavigationBar: BottomNavigationBar(
          currentIndex: _currentIndex, //koji ce biti dole selektovan
          items: const [
            BottomNavigationBarItem(
                icon: Icon(Icons.home),
                label: "Home",
                backgroundColor: Colors.blue),
            BottomNavigationBarItem(
                icon: Icon(Icons.search),
                label: "Search",
                backgroundColor: Colors.blue),
            BottomNavigationBarItem(
                icon: Icon(Icons.camera),
                label: "Camera",
                backgroundColor: Colors.blue),
            BottomNavigationBarItem(
                icon: Icon(Icons.person),
                label: "person",
                backgroundColor: Colors.blue),
          ],
          onTap: onTappedBar),
    );
  }
}
