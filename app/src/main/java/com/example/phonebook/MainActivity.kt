package com.example.phonebook

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private val contacts = mutableListOf<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contacts.add(Contact("Alice", "111-222-3333", "alice@gmail.com"))
        contacts.add(Contact("Bob", "222-333-4444", "bob@gmail.com"))
        contacts.add(Contact("Charlie", "333-444-5555", "charlie@gmail.com"))
        contacts.add(Contact("David", "444-555-6666", "david@gmail.com"))
        contacts.add(Contact("Eva", "555-666-7777", "eva@gmail.com"))
        contacts.add(Contact("Frank", "666-777-8888", "frank@gmail.com"))
        contacts.add(Contact("Grace", "777-888-9999", "grace@gmail.com"))
        contacts.add(Contact("Hank", "888-999-0000", "hank@gmail.com"))
        contacts.add(Contact("Ivy", "999-000-1111", "ivy@gmail.com"))
        contacts.add(Contact("Jack", "000-111-2222", "jack@gmail.com"))
        contacts.add(Contact("Kelly", "111-222-3333", "kelly@gmail.com"))
        contacts.add(Contact("Leo", "222-333-4444", "leo@gmail.com"))
        contacts.add(Contact("Mia", "333-444-5555", "mia@gmail.com"))
        contacts.add(Contact("Nathan", "444-555-6666", "nathan@gmail.com"))
        contacts.add(Contact("Olivia", "555-666-7777", "olivia@gmail.com"))
        contacts.add(Contact("Peter", "666-777-8888", "peter@gmail.com"))
        contacts.add(Contact("Quinn", "777-888-9999", "quinn@gmail.com"))
        contacts.add(Contact("Ryan", "888-999-0000", "ryan@gmail.com"))
        contacts.add(Contact("Sara", "999-000-1111", "sara@gmail.com"))





        val contactAdapter = ContactAdapter(this, contacts)
        val recyclerView: RecyclerView = findViewById(R.id.contact_rv)
        recyclerView.adapter = contactAdapter
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        registerForContextMenu(recyclerView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val position = info.position
        val contact = contacts[position]
        return when (item.itemId) {
            R.id.action_call -> {
                callContact(contact.phoneNumber)
                true
            }

            R.id.action_send_message -> {
                sendSms(contact.phoneNumber)
                true
            }

            R.id.action_send_email -> {
                sendEmail(contact.email)
                true
            }

            else -> super.onContextItemSelected(item)
        }
    }

    private fun callContact(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
        startActivity(intent)
    }

    private fun sendSms(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$phoneNumber"))
        startActivity(intent)
    }

    private fun sendEmail(email: String) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:$email")
        startActivity(intent)
    }
}