from __future__ import annotations
from typing import List
from enums import TipoEscuadra
from soldado import Soldado


class Escuadra:
    """
    Clase Escuadra
    Atributos:
      - nombre: str
      - numero: int
      - tipo: TipoEscuadra
      - soldados: List[Soldado]
      - max_soldados_por_escuadra: int (class attribute)
    """

    max_soldados_por_escuadra: int = 10  # atributo estático

    def __init__(self, nombre: str, numero: int, tipo: TipoEscuadra):
        if not isinstance(tipo, TipoEscuadra):
            raise TypeError("tipo debe ser TipoEscuadra")
        self.nombre: str = nombre
        self.numero: int = numero
        self.tipo: TipoEscuadra = tipo
        self.soldados: List[Soldado] = []

    def agregar_soldado(self, s: Soldado) -> bool:
        """Intenta agregar un soldado. Devuelve True si se agregó, False si no hay capacidad."""
        if s is None:
            raise ValueError("soldado no puede ser None")
        if not self.tiene_capacidad_disponible():
            return False
        self.soldados.append(s)
        return True

    def remover_soldado_por_nombre(self, nombre: str) -> bool:
        """Elimina el primer soldado que coincida por nombre (case-insensitive)."""
        nombre_lower = nombre.lower()
        for i, s in enumerate(self.soldados):
            if s.nombre.lower() == nombre_lower:
                del self.soldados[i]
                return True
        return False

    def contar_soldados(self) -> int:
        return len(self.soldados)

    def tiene_capacidad_disponible(self) -> bool:
        return len(self.soldados) < Escuadra.max_soldados_por_escuadra

    def obtener_soldados_aptos(self) -> List[Soldado]:
        return [s for s in self.soldados if s.es_apto_para_mision()]

    @classmethod
    def cambiar_maximo_soldados(cls, nuevo_maximo: int) -> None:
        if nuevo_maximo < 0:
            raise ValueError("nuevo_maximo debe ser >= 0")
        cls.max_soldados_por_escuadra = nuevo_maximo

    def descripcion(self) -> str:
        return f"Escuadra {self.nombre} (#{self.numero}) Tipo: {self.tipo.name} - Soldados: {len(self.soldados)}"

    def __repr__(self) -> str:
        return f"<Escuadra {self.nombre} #{self.numero}>"
