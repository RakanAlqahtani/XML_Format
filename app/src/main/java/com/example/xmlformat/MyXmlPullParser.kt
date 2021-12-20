package com.example.xmlformat

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream
import java.lang.reflect.Array.newInstance
import javax.xml.datatype.DatatypeFactory.newInstance

class MyXmlPullParser {

    private val student = ArrayList<Student>()
        private var text : String? = null

    private var studentName = ""
    private var studentGrade = 0.0

    fun parse(inputStream : InputStream): ArrayList<Student> {

        try {

            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT){
            val tagName = parser.name
            when (eventType){
                XmlPullParser.TEXT -> text = parser.text
                XmlPullParser.END_TAG -> when {
                    tagName.equals("name", ignoreCase = true) -> {
                        studentName = text.toString()
                    }
                    tagName.equals("grade", ignoreCase = true) -> {
                        studentGrade = text!!.toDouble()
                    }
                    else -> student.add(Student(studentName, studentGrade))
                }
                else ->{

                }

                }
                eventType = parser.next()
            }

            }catch (e : XmlPullParserException){
                e.printStackTrace()
            }catch (e : IOException){
                e.printStackTrace()
            }
        return student

        }



    }


