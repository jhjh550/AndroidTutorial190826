package com.fieldbear.androidtutorial190826.T02_Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fieldbear.androidtutorial190826.R;

public class T02_Activity extends AppCompatActivity {

    private static final int MY_REQ_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t02_);


        Button btnPhone = findViewById(R.id.btnPhone);
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+"01012345678"));
                startActivity(intent);
            }
        });

        Button btnNewActivity = findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        T02_Activity.this,
                        T02_New_Activity.class);
                intent.putExtra("myValue", 100);
//                startActivity(intent);
                startActivityForResult(intent, MY_REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == MY_REQ_CODE){
            if(resultCode == RESULT_OK){
                int value = data.getIntExtra("myResult", 0);
                Toast.makeText(this, "value: "+value,
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}


/*
android.app.action.ADD_DEVICE_ADMIN
android.app.action.MANAGED_PROFILE_PROVISIONED
android.app.action.PROVISIONING_SUCCESSFUL
android.app.action.PROVISION_MANAGED_DEVICE
android.app.action.PROVISION_MANAGED_PROFILE
android.app.action.SET_NEW_PARENT_PROFILE_PASSWORD
android.app.action.SET_NEW_PASSWORD
android.app.action.START_ENCRYPTION
android.appwidget.action.APPWIDGET_BIND
android.appwidget.action.APPWIDGET_CONFIGURE
android.appwidget.action.APPWIDGET_PICK
android.bluetooth.adapter.action.REQUEST_DISCOVERABLE
android.bluetooth.adapter.action.REQUEST_ENABLE
android.content.pm.action.CONFIRM_PIN_APPWIDGET
android.content.pm.action.CONFIRM_PIN_SHORTCUT
android.content.pm.action.SESSION_DETAILS
android.intent.action.ALL_APPS
android.intent.action.ANSWER
android.intent.action.APPLICATION_PREFERENCES
android.intent.action.APP_ERROR
android.intent.action.ASSIST
android.intent.action.ATTACH_DATA
android.intent.action.BUG_REPORT
android.intent.action.CALL
android.intent.action.CALL_BUTTON
android.intent.action.CARRIER_SETUP
android.intent.action.CHOOSER
android.intent.action.CREATE_DOCUMENT
android.intent.action.CREATE_LIVE_FOLDER
android.intent.action.CREATE_SHORTCUT
android.intent.action.DELETE
android.intent.action.DIAL
android.intent.action.DISMISS_ALARM
android.intent.action.EDIT
android.intent.action.EVENT_REMINDER
android.intent.action.FACTORY_TEST
android.intent.action.GET_CONTENT
android.intent.action.INSERT
android.intent.action.INSERT_OR_EDIT
android.intent.action.INSTALL_FAILURE
android.intent.action.INSTALL_PACKAGE
android.intent.action.MAIN
android.intent.action.MANAGE_NETWORK_USAGE
android.intent.action.MEDIA_SEARCH
android.intent.action.MUSIC_PLAYER
android.intent.action.OPEN_DOCUMENT
android.intent.action.OPEN_DOCUMENT_TREE
android.intent.action.PASTE
android.intent.action.PICK
android.intent.action.PICK_ACTIVITY
android.intent.action.POWER_USAGE_SUMMARY
android.intent.action.PROCESS_TEXT
android.intent.action.QUICK_VIEW
android.intent.action.RINGTONE_PICKER
android.intent.action.RUN
android.intent.action.SEARCH
android.intent.action.SEARCH_LONG_PRESS
android.intent.action.SEND
android.intent.action.SENDTO
android.intent.action.SEND_MULTIPLE
android.intent.action.SET_ALARM
android.intent.action.SET_TIMER
android.intent.action.SET_WALLPAPER
android.intent.action.SHOW_ALARMS
android.intent.action.SHOW_APP_INFO
android.intent.action.SHOW_TIMERS
android.intent.action.SNOOZE_ALARM
android.intent.action.SYNC
android.intent.action.SYSTEM_TUTORIAL
android.intent.action.UNINSTALL_PACKAGE
android.intent.action.VIEW
android.intent.action.VIEW_DOWNLOADS
android.intent.action.VOICE_COMMAND
android.intent.action.WEB_SEARCH
android.media.action.DISPLAY_AUDIO_EFFECT_CONTROL_PANEL
android.media.action.IMAGE_CAPTURE
android.media.action.IMAGE_CAPTURE_SECURE
android.media.action.MEDIA_PLAY_FROM_SEARCH
android.media.action.STILL_IMAGE_CAMERA
android.media.action.STILL_IMAGE_CAMERA_SECURE
android.media.action.TEXT_OPEN_FROM_SEARCH
android.media.action.VIDEO_CAMERA
android.media.action.VIDEO_CAPTURE
android.media.action.VIDEO_PLAY_FROM_SEARCH
android.media.tv.action.REQUEST_CHANNEL_BROWSABLE
android.net.conn.CAPTIVE_PORTAL
android.net.scoring.CHANGE_ACTIVE
android.net.scoring.CUSTOM_ENABLE
android.net.wifi.PICK_WIFI_NETWORK
android.net.wifi.action.REQUEST_SCAN_ALWAYS_AVAILABLE
android.nfc.action.NDEF_DISCOVERED
android.nfc.action.TAG_DISCOVERED
android.nfc.action.TECH_DISCOVERED
android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT
android.os.storage.action.MANAGE_STORAGE
android.provider.MediaStore.RECORD_SOUND
android.provider.Telephony.ACTION_CHANGE_DEFAULT
android.provider.action.QUICK_CONTACT
android.provider.action.VOICE_SEND_MESSAGE_TO_CONTACTS
android.provider.calendar.action.HANDLE_CUSTOM_EVENT
android.search.action.SEARCH_SETTINGS
android.service.wallpaper.CROP_AND_SET_WALLPAPER
android.settings.ACCESSIBILITY_SETTINGS
android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS
android.settings.ACTION_PRINT_SETTINGS
android.settings.ADD_ACCOUNT_SETTINGS
android.settings.AIRPLANE_MODE_SETTINGS
android.settings.APN_SETTINGS
android.settings.APPLICATION_DETAILS_SETTINGS
android.settings.APPLICATION_DEVELOPMENT_SETTINGS
android.settings.APPLICATION_SETTINGS
android.settings.APP_NOTIFICATION_SETTINGS
android.settings.BATTERY_SAVER_SETTINGS
android.settings.BLUETOOTH_SETTINGS
android.settings.CAPTIONING_SETTINGS
android.settings.CAST_SETTINGS
android.settings.CHANNEL_NOTIFICATION_SETTINGS
android.settings.DATA_ROAMING_SETTINGS
android.settings.DATE_SETTINGS
android.settings.DEVICE_INFO_SETTINGS
android.settings.DISPLAY_SETTINGS
android.settings.DREAM_SETTINGS
android.settings.HARD_KEYBOARD_SETTINGS
android.settings.HOME_SETTINGS
android.settings.IGNORE_BACKGROUND_DATA_RESTRICTIONS_SETTINGS
android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS
android.settings.INPUT_METHOD_SETTINGS
android.settings.INPUT_METHOD_SUBTYPE_SETTINGS
android.settings.INTERNAL_STORAGE_SETTINGS
android.settings.LOCALE_SETTINGS
android.settings.LOCATION_SOURCE_SETTINGS
android.settings.MANAGE_ALL_APPLICATIONS_SETTINGS
android.settings.MANAGE_APPLICATIONS_SETTINGS
android.settings.MANAGE_DEFAULT_APPS_SETTINGS
android.settings.MANAGE_UNKNOWN_APP_SOURCES
android.settings.MEMORY_CARD_SETTINGS
android.settings.NETWORK_OPERATOR_SETTINGS
android.settings.NFCSHARING_SETTINGS
android.settings.NFC_PAYMENT_SETTINGS
android.settings.NFC_SETTINGS
android.settings.NIGHT_DISPLAY_SETTINGS
android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS
android.settings.PRIVACY_SETTINGS
android.settings.QUICK_LAUNCH_SETTINGS
android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
android.settings.REQUEST_SET_AUTOFILL_SERVICE
android.settings.SECURITY_SETTINGS
android.settings.SETTINGS
android.settings.SHOW_REGULATORY_INFO
android.settings.SOUND_SETTINGS
android.settings.SYNC_SETTINGS
android.settings.USAGE_ACCESS_SETTINGS
android.settings.USER_DICTIONARY_SETTINGS
android.settings.VOICE_CONTROL_AIRPLANE_MODE
android.settings.VOICE_CONTROL_BATTERY_SAVER_MODE
android.settings.VOICE_CONTROL_DO_NOT_DISTURB_MODE
android.settings.VOICE_INPUT_SETTINGS
android.settings.VPN_SETTINGS
android.settings.VR_LISTENER_SETTINGS
android.settings.WEBVIEW_SETTINGS
android.settings.WIFI_IP_SETTINGS
android.settings.WIFI_SETTINGS
android.settings.WIRELESS_SETTINGS
android.settings.ZEN_MODE_PRIORITY_SETTINGS
android.settings.action.MANAGE_OVERLAY_PERMISSION
android.settings.action.MANAGE_WRITE_SETTINGS
android.speech.tts.engine.CHECK_TTS_DATA
android.speech.tts.engine.GET_SAMPLE_TEXT
android.speech.tts.engine.INSTALL_TTS_DATA
android.telephony.action.CONFIGURE_VOICEMAIL
android.telephony.euicc.action.MANAGE_EMBEDDED_SUBSCRIPTIONS
android.telephony.euicc.action.PROVISION_EMBEDDED_SUBSCRIPTION
com.android.contacts.action.FILTER_CONTACTS

 */