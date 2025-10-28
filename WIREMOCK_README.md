# 🧰 WireMock Cloud — Guía completa para simular APIs REST y SOAP

WireMock Cloud es una plataforma SaaS que permite **crear, simular y probar APIs REST o SOAP** sin necesidad de un backend real.  
Ideal para desarrolladores, testers y equipos DevOps que necesiten endpoints de prueba en entornos locales o remotos.

---

## 🚀 Contenido

1. [Registro y configuración inicial](#-registro-y-configuración-inicial)
2. [Creación de un proyecto y endpoints](#-creación-de-un-proyecto-y-endpoints)
4. [Simular un endpoint SOAP](#-simular-un-endpoint-soap)
5. [Consumir los endpoints](#-consumir-los-endpoints)
6. [Autenticación y seguridad](#-autenticación-y-seguridad)

---

## 🪜 Registro y configuración inicial

1. Visita 👉 [https://app.wiremock.cloud](https://app.wiremock.cloud)
2. Crea una cuenta gratuita (**Sign Up / Start for free**)
3. Inicia sesión en tu panel de control.
4. Crea un **Workspace** o usa el predeterminado.

Tu cuenta generará una **base URL** similar a: ``` https://<tu-proyecto>.wiremockapi.cloud ```


Todos tus mocks se servirán desde esa dirección.

---

## 🧱 Creación de un proyecto y endpoints

1. En el panel izquierdo, haz clic en **“Create Project”**.
2. Asigna un nombre, por ejemplo: `DemoSOAPProject`.
3. Una vez creado, selecciona **“Create Stub Mapping”** para definir un nuevo endpoint.

---

## 🧩 Simular un endpoint SOAP

1. Haz clic en **“New Endpoint”**.
2. Configura los campos:
    - **Method:** `GET` o `POST`
    - **Path:** `/soap/clientes`
3. configurar request body:
    - click en opcion `advanced`
    - seleccionar opcion `body`
    - opcion: `equals XML`
    - colocar el body xml dentro del campo de texto
4. En la Opcion **Response**:
    - **Status:** `200`
    - **Content-Type:** `text/xml`
    - **Body:**
      ```xml
        <getClienteRequest>
            <idCliente>12345</idCliente>
        </getClienteRequest>
      ```
4. Guarda los cambios.

✅ Tu endpoint estará disponible en: ``` https://<tu-proyecto>.wiremockapi.cloud/soap/clientes ```


### 📡 Prueba rápida

**Con cURL:**
```bash
  curl https://<tu-proyecto>.wiremockapi.cloud/api/clientes
```

