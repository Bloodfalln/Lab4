package com.example.lab4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
   /* private val contacts = listOf<Contact>() // Порожній список для тестування*/
        private val contacts = listOf(
            Contact("Вікторія Соловей", "+380-56-975-83-51", "Івано-Франківськ", "lyudmyla.moroz@gmail.com"),
            Contact("Михайло Довженко", "+380-52-579-21-88", "Одеса", "mykola.tkachuk@gmail.com"),
            Contact("Ігор Павлюк", "+380-63-766-51-66", "Ужгород", "oleksiy.golovko@gmail.com"),
            Contact("Володимир Петрович", "+380-75-402-38-35", "Миколаїв", "yuriy.sydorenko@gmail.com"),
            Contact("Юрій Сидоренко", "+380-92-605-98-94", "Черкаси", "svitlana.ivanchenko@gmail.com"),
            Contact("Ірина Бондар", "+380-50-407-21-55", "Львів", "lyudmyla.moroz@gmail.com"),
            Contact("Катерина Зайцева", "+380-93-522-38-33", "Житомир", "oksana.kravchenko@gmail.com"),
            Contact("Катерина Зайцева", "+380-57-809-78-12", "Київ", "lyudmyla.moroz@gmail.com"),
            Contact("Олександр Шевченко", "+380-93-523-43-17", "Львів", "dmytro.melnyk@gmail.com"),
            Contact("Олена Грищенко", "+380-85-156-24-22", "Луцьк", "andriy.ivanenko@gmail.com"),
            Contact("Олексій Головко", "+380-64-106-13-99", "Херсон", "yuriy.sydorenko@gmail.com"),
            Contact("Ірина Бондар", "+380-69-559-31-92", "Чернігів", "oksana.kravchenko@gmail.com"),
            Contact("Олена Грищенко", "+380-76-737-15-81", "Одеса", "tetyana.mykolayenko@gmail.com"),
            Contact("Микола Ткачук", "+380-53-937-62-62", "Запоріжжя", "svitlana.ivanchenko@gmail.com"),
            Contact("Микола Ткачук", "+380-85-644-11-52", "Київ", "svitlana.ivanchenko@gmail.com"),
            Contact("Дмитро Мельник", "+380-53-453-16-81", "Вінниця", "oleksiy.golovko@gmail.com"),
            Contact("Катерина Зайцева", "+380-81-522-58-51", "Миколаїв", "dmytro.melnyk@gmail.com"),
            Contact("Вікторія Соловей", "+380-83-175-35-59", "Миколаїв", "lyudmyla.moroz@gmail.com"),
            Contact("Людмила Мороз", "+380-52-946-37-23", "Суми", "kateryna.zaytseva@gmail.com"),
            Contact("Олексій Головко", "+380-86-769-66-94", "Харків", "volodymyr.petrovych@gmail.com"),

            )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val emptyMessage: TextView = findViewById(R.id.empty_message)

        if (contacts.isEmpty()) {
            emptyMessage.apply {
                text = "Список порожній"
                visibility = View.VISIBLE
            }
            recyclerView.visibility = View.GONE
        } else {
            recyclerView.visibility = View.VISIBLE
            emptyMessage.visibility = View.GONE

            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ContactAdapter(contacts) { contact ->
                val intent = Intent(this, ContactDetailActivity::class.java).apply {
                    putExtra("CONTACT_NAME", contact.name)
                    putExtra("CONTACT_NUMBER", contact.number)
                    putExtra("CONTACT_CITY", contact.city)
                    putExtra("CONTACT_EMAIL", contact.email)
                }
                startActivity(intent)
            }
        }
    }
}