from enum import Enum


class RangoSoldado(Enum):
    RECLUTA = "RECLUTA"
    SOLDADO = "SOLDADO"
    CABO = "CABO"
    SARGENTO = "SARGENTO"
    TENIENTE = "TENIENTE"


class TipoEscuadra(Enum):
    INFANTERIA = "INFANTERIA"
    RECONOCIMIENTO = "RECONOCIMIENTO"
    APOYO = "APOYO"


class TipoPeloton(Enum):
    ASALTO = "ASALTO"
    ENTRENAMIENTO = "ENTRENAMIENTO"
    APOYO = "APOYO"


class TipoBatallon(Enum):
    LIGERO = "LIGERO"
    MECANIZADO = "MECANIZADO"
    AEROTRANSPORTADO = "AEROTRANSPORTADO"
