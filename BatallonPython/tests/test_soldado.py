from enums import RangoSoldado
from soldado import Soldado

def test_es_apto_para_mision_true():
    s = Soldado("Test", 25, RangoSoldado.SOLDADO, "APTO")
    assert s.es_apto_para_mision()

def test_no_es_apto_por_edad():
    s = Soldado("Young", 16, RangoSoldado.RECLUTA, "APTO")
    assert not s.es_apto_para_mision()

def test_marcar_como_herido():
    s = Soldado("T", 30, RangoSoldado.CABO, "APTO")
    s.marcar_como_herido()
    assert s.estado_salud == "HERIDO"
