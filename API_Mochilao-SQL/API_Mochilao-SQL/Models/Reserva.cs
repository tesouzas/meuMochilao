using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace API_Mochilao_SQL.Models
{

    [Table("Reserva")]
    public class Reserva
    {
        [Key]
        public int id_reserva { get; set; }

        [Required(ErrorMessage = "Digite a data de ida:")]
        public int data_ida { get; set; }

        [Required(ErrorMessage = "Digite a data de volta:")]
        public int data_volta { get; set; }

        [Required(ErrorMessage = "Informe o valor da reserva:")]
        public Double valor_reserva { get; set; }

        [Required(ErrorMessage = "Informe os dias da reserva:")]
        public int dias_reserva { get; set; }
    }

}
