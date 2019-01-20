# MDDatePicker


![image](https://github.com/JunGenius/MDDatePicker/blob/master/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190120020205.png)


eg:

1. build.gradle

                allprojects {
                     repositories {
                         google()
                         jcenter()

                         maven { url 'https://www.jitpack.io' }
                     }
                 }


2. app  build.gradle

                dependencies {
                    implementation 'com.github.JunGenius:MDDatePicker:1.1.0'
                 }



代码:

 

                new MDCalendarDialog.Builder(this)
                
                        .setTitle("请选择日期") // 标题

                        .setIsCancel(false) // 设置是否外部点击可取消

                        .setCurrentDate(new Date()) // 当前选中的日期

                        .setSelectionColor(Color.parseColor("#03a9f4")) // 选中背景颜色

                        .setSureBackGroudColor(R.drawable.default_button_bg)// 确定按钮背景颜色

                        .onDetermineSeleterListener(new MDCalendarDialog.OnDetermineSelectorListener() {

                            @Override
                            public void determineSelector(String dateStr, Date date) {
                                // 选中日期事件
                            }

                            @Override
                            public void noSelector() {
                                // 没选中日期事件
                            }
                        })
                        .build()
                        .show();
