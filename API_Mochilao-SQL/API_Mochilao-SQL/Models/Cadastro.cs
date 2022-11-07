using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace API_Mochilao_SQL.Models
{

    [Table("Cadastro")]
    public class Cadastro
    {
        [Key]
        public int id { get; set; }

        [Required(ErrorMessage = "Informe a cidade:")]
        [StringLength(50)]
        public string cidade { get; set; }

        [Required(ErrorMessage = "Informe o email:")]
        [StringLength(50)]
        public string email { get; set; }

        [Required(ErrorMessage = "Informe o estado:")]
        [StringLength(50)]
        public string estado { get; set; }

        [Required(ErrorMessage = "Informe o Nome:")]
        [StringLength(50)]
        public string nome { get; set; }

        [Required(ErrorMessage = "Informe o rg")]
        public int rg { get; set; }

        [Required(ErrorMessage = "Informe o rg")]
        public string senha { get; set; }

        [Required(ErrorMessage = "Informe o telefone")]
        public int telefone { get; set; }

    }
}

