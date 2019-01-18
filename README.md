# MDDatePicker

eg:

1.maven { url 'https://www.jitpack.io' }

2.implementation 'com.github.JunGenius:MDDatePicker:1.0.5'

代码:

 

                new MDCalendarDialog.Builder(this)
                
                        .setTitle("请选择日期")

                        .setIsCancel(false)

                        .setCurrentDate(new Date())

                        .setSelectionColor(Color.parseColor("#03a9f4"))

                        .setSureBackGroudColor(R.drawable.de)

                        .onDetermineSeleterListener(new MDCalendarDialog.OnDetermineSelectorListener() {

                            @Override
                            public void determineSelector(String dateStr, Date date) {

                            }

                            @Override
                            public void noSelector() {

                            }
                        })
                        .build()
                        .show();
