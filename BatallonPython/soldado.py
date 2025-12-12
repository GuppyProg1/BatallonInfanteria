
from enums import RangoSoldado


class Soldado:
    """
    Clase Soldado
    Atributos:
      - nombre: str
      - edad: int
      - rango: RangoSoldado
      - estado_salud: str ("APTO", "HERIDO", etc.)
      - edad_minima_servicio: int (class attribute)
    """

    edad_minima_servicio: int = 18  # atributo estático (class-level)

    def __init__(self, nombre: str, edad: int, rango: RangoSoldado, estado_salud: str = "APTO"):
        if edad < 0:
            raise ValueError("La edad no puede ser negativa")
        if not isinstance(rango, RangoSoldado):
            raise TypeError("rango debe ser una instancia de RangoSoldado")
        self.nombre: str = nombre
        self.edad: int = edad
        self.rango: RangoSoldado = rango
        self.estado_salud: str = estado_salud.upper()

    def entrenar(self) -> None:
        """Simula entrenamiento — cambia (temporalmente) el estado o imprime acción."""
        # Decidimos mantener el estado y mostrar un mensaje
        print(f"{self.nombre} está entrenando.")
        # Podríamos cambiar estado_salud si se desea:
        # self.estado_salud = "ENTRENANDO"

    def asignar_rango(self, nuevo_rango: RangoSoldado) -> None:
        if not isinstance(nuevo_rango, RangoSoldado):
            raise TypeError("nuevo_rango debe ser RangoSoldado")
        self.rango = nuevo_rango

    def marcar_como_herido(self) -> None:
        self.estado_salud = "HERIDO"

    def es_apto_para_mision(self) -> bool:
        """Devuelve True si cumple edad_minima_servicio y estado_salud == 'APTO'"""
        return (self.edad >= Soldado.edad_minima_servicio) and (self.estado_salud == "APTO")

    def descripcion(self) -> str:
        return f"Soldado: {self.nombre} | Edad: {self.edad} | Rango: {self.rango.name} | Salud: {self.estado_salud}"

    @classmethod
    def cambiar_edad_minima_servicio(cls, nueva_edad: int) -> None:
        if nueva_edad < 0:
            raise ValueError("La edad mínima no puede ser negativa")
        cls.edad_minima_servicio = nueva_edad

    # métodos de acceso pythonicos
    def __repr__(self) -> str:
        return f"<Soldado {self.nombre} ({self.rango.name})>"
