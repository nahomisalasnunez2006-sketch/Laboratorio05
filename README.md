# Laboratorio 05 — Polimorfismo en Java

**Unidad:** 5 — Polimorfismo  
**Materia:** Programación Orientada a Objetos  

---

## Preguntas de Reflexión

### 1. ¿Cuál es la diferencia entre sobreescritura (`@Override`) y sobrecarga (overload)? Da un ejemplo de cada uno tomado de este laboratorio.
* **Sobrescritura (`@Override`):** Ocurre cuando una clase hija redefine un método que ya existía en su clase padre manteniendo exactamente la misma firma. Se resuelve en **tiempo de ejecución** (polimorfismo). 
  * *Ejemplo en el lab:* El método `calcularDanio()` definido en `Personaje` es sobrescrito en `Guerrero`, `Mago` y `Arquero` para calcular el daño de forma distinta según sus propios atributos.
* **Sobrecarga (overload):** Ocurre cuando en una misma clase existen varios métodos con el **mismo nombre pero con distinta firma** (diferente número, tipo o orden de parámetros). Se resuelve en **tiempo de compilación**. 
  * *Ejemplo en el lab:* Los tres métodos `ejecutarAtaque(...)` en la clase `GestorBatalla` (uno recibe un personaje, otro recibe atacante y defensor, y otro recibe un arreglo de personajes).

---

### 2. Si tienes `Personaje p = new Mago(...)` y llamas `p.calcularDanio()`, ¿Java usa el método de `Personaje` o el de `Mago`? ¿Por qué?
Java usa el método de **`Mago`**. Esto ocurre debido al **despacho dinámico de métodos** en tiempo de ejecución (*dynamic method dispatch*). Aunque la variable de referencia es de tipo `Personaje`, el objeto real que se encuentra alojado en la memoria es una instancia de `Mago`, por lo que Java ejecuta la versión sobrescrita más específica.

---

### 3. ¿Para qué sirve `instanceof`? ¿En qué situaciones lo usarías en un sistema real?
* **Utilidad:** El operador `instanceof` sirve para verificar de qué tipo real es un objeto en tiempo de ejecución antes de realizar una conversión (*casting*). 
* **Uso en un sistema real:** Se usaría, por ejemplo, cuando procesas una lista genérica de transacciones o pagos y necesitas aplicar una lógica exclusiva o un descuento especial únicamente si el objeto evaluado corresponde a una clase específica (como `PagoConTarjeta` o `FacturaEmpresarial`).