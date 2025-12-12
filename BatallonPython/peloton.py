from __future__ import annotations
from typing import List
from enums import TipoPeloton
from escuadra import Escuadra


class Peloton:
    """
    Clase Peloton
    Atributos:
      - nombre: str
      - comandante: str
      - tipo: TipoPeloton
      - escuadras: List[Escuadra]
      - max_escuadras: int (class attribute)
    """

    max_escuadras: int = 5

    def __init__(self, nombre: str, comandante: str, tipo: TipoPeloton):
        if not isinstance(tipo, TipoPeloton):
            raise TypeError("tipo debe ser TipoPeloton")
        self.nombre: str = nombre
        self.comandante: str = comandante
        self.tipo: TipoPeloton = tipo
        self.escuadras: List[Escuadra] = []

    def agregar_escuadra(self, e: Escuadra) -> bool:
        if e is None:
            raise ValueError("escuadra no puede ser None")
        if len(self.escuadras) >= Peloton.max_escuadras:
            return False
        self.escuadras.append(e)
        return True

    def remover_escuadra_por_nombre(self, nombre: str) -> bool:
        nombre_lower = nombre.lower()
        for i, e in enumerate(self.escuadras):
            if e.nombre.lower() == nombre_lower:
                del self.escuadras[i]
                return True
        return False

    def contar_escuadras(self) -> int:
        return len(self.escuadras)

    def contar_total_soldados(self) -> int:
        return sum(e.contar_soldados() for e in self.escuadras)

    def es_peloton_completo(self) -> bool:
        return len(self.escuadras) >= Peloton.max_escuadras

    @classmethod
    def cambiar_max_escuadras(cls, nuevo_max: int) -> None:
        if nuevo_max < 0:
            raise ValueError("nuevo_max debe ser >= 0")
        cls.max_escuadras = nuevo_max

    def descripcion(self) -> str:
        return (f"Pelotón {self.nombre} | Comandante: {self.comandante} | Tipo: {self.tipo.name} | "
                f"Escuadras: {len(self.escuadras)} | Soldados totales: {self.contar_total_soldados()}")
