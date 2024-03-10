package logica;

import java.sql.SQLException;
import java.util.List;

public interface IDAO <T, V>{
	
	 /**
     * @param model objeto que guardará
     * @return true si se creó el registro, false si falló
	 * @throws SQLException 
     */
    public boolean createRecord(T model) throws SQLException;

    /**
     * @param idModel clave del registro a consultar
     * @return el registro encontrado
     */
    public T readRecord(V idModel);

    /**
     *
     * @param model objeto con nuevos valores a almacenar
     * @param idModel clave del registro a modificar
     * @return 
     */
    public boolean updateRecord(T model, V idModel);

    /**
     *
     * @param idModel clave del registro a eliminar
     * @return 
     */
    public boolean deleteRecord(V idModel);

    /**
     *
     * @return lista de todos los registros
     */
    public List<T> readRecords();
}
