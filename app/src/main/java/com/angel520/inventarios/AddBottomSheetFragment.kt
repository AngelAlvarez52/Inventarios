package com.angel520.inventarios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.UUID


class AddBottomSheetFragment : BottomSheetDialogFragment()  {

    interface OnAddDeviceListener {
        fun onDeviceAdded(device: Productos)
    }

    private var listener: OnAddDeviceListener? = null

    fun setOnAddDeviceListener(listener: OnAddDeviceListener) {
        this.listener = listener
    }

    fun generateUniqueDeviceID(): Int {
        // Generar un UUID (Identificador Único Universal) aleatorio
        val uuid = UUID.randomUUID()

        // Obtener un número único a partir del hash del UUID
        val number = uuid.hashCode()

        // Asegurarse de que el número sea siempre positivo
        return if (number < 0) - number else number
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_bottom_sheet, container, false)

        val editTextName = view.findViewById<EditText>(R.id.editTextName)
        val editTextPrecio = view.findViewById<EditText>(R.id.editTextPrecio)
        val editTextCantidad = view.findViewById<EditText>(R.id.editTextCantidad)
        val buttonAddDevice = view.findViewById<Button>(R.id.buttonAddDevice)

        buttonAddDevice.setOnClickListener {
            val deviceName = editTextName.text.toString()
            val ipAddress = editTextPrecio.text.toString()
            val macAddress = editTextCantidad.text.toString()

            // Validar los datos y crear un objeto NetworkDevice
            if (deviceName.isNotEmpty() && ipAddress.isNotEmpty() && macAddress.isNotEmpty()) {
                val newDevice = Productos(
                    id = generateUniqueDeviceID(),
                    name = deviceName,
                    Precio = ipAddress,
                    Existencia = macAddress)

                // Llamar al método onDeviceAdded de la interfaz
                listener?.onDeviceAdded(newDevice)

                // Cerrar el diálogo
                dismiss()
            } else {
                // Mostrar un mensaje de error o manejar la validación de datos incompletos
            }
        }



        return view
    }

}