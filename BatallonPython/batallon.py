from __future__ import annotations
from typing import List
from enums import TipoBatallon
from peloton import Peloton


class Batallon:
    """
    Clase Batallon
    Atributos:
      - nombre: str
      - ubicacion: str
      - tipo: TipoBatallon
      - pelotones: List[Peloton]
      - codigo_otan: str (class attribute)
    """

    codigo_otan: str = "OTAN-DEFAULT"

    def __init__(self, nombre: str, ubicacion: str, tipo: TipoBatallon):
        if not isinstance(tipo, TipoBatallon):
            raise TypeError("tipo debe ser TipoBatallon")
        self.nombre: str = nombre
        self.ubicacion: str = ubicacion
        self.tipo: TipoBatallon = tipo
        self.pelotones: List[Peloton] = []

    def agregar_peloton(self, p: Peloton) -> bool:
        if p is None:
            raise ValueError("peloton no puede ser None")
        self.pelotones.append(p)
        return True

    def remover_peloton_por_nombre(self, nombre: str) -> bool:
        nombre_lower = nombre.lower()
        for i, p in enumerate(self.pelotones):
            if p.nombre.lower() == nombre_lower:
                del self.pelotones[i]
                return True
        return False

    def contar_pelotones(self) -> int:
        return len(self.pelotones)

    def contar_total_soldados(self) -> int:
        return sum(p.contar_total_soldados() for p in self.pelotones)

    def generar_reporte_resumen(self) -> str:
        return (
            f"Batallón: {self.nombre}\n"
            f"Ubicación: {self.ubicacion}\n"
            f"Tipo: {self.tipo.name}\n"
            f"Pelotones: {len(self.pelotones)}\n"
            f"Total Soldados: {self.contar_total_soldados()}\n"
            f"Código OTAN: {Batallon.codigo_otan}"
        )

    @classmethod
    def cambiar_codigo_otan(cls, nuevo_codigo: str) -> None:
        cls.codigo_otan = nuevo_codigo

    def descripcion(self) -> str:
        return f"{self.nombre} ({self.ubicacion}) - {self.tipo.name} - Pelotones: {len(self.pelotones)}"
