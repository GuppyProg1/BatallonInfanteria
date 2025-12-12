from enums import TipoEscuadra, RangoSoldado
from escuadra import Escuadra
from soldado import Soldado

def test_agregar_y_contar():
    e = Escuadra("A", 1, TipoEscuadra.INFANTERIA)
    s = Soldado("S1", 20, RangoSoldado.SOLDADO, "APTO")
    assert e.agregar_soldado(s)
    assert e.contar_soldados() == 1

def test_no_agregar_si_llena():
    Escuadra.cambiar_maximo_soldados(1)
    e = Escuadra("B", 2, TipoEscuadra.APOYO)
    e.agregar_soldado(Soldado("S1", 20, RangoSoldado.SOLDADO, "APTO"))
    assert not e.agregar_soldado(Soldado("S2", 21, RangoSoldado.SOLDADO, "APTO"))

def test_obtener_soldados_aptos():
    e = Escuadra("C", 3, TipoEscuadra.RECONOCIMIENTO)
    e.agregar_soldado(Soldado("A1", 20, RangoSoldado.SOLDADO, "APTO"))
    e.agregar_soldado(Soldado("H1", 22, RangoSoldado.SOLDADO, "HERIDO"))
    aptos = e.obtener_soldados_aptos()
    assert len(aptos) == 1
