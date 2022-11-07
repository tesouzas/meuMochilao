using Microsoft.EntityFrameworkCore;
using MySqlX.XDevAPI;

namespace API_Mochilao_SQL.Models
{
    public class MochilaoDbContext : DbContext
    {
        public MochilaoDbContext(DbContextOptions<MochilaoDbContext> options) : base(options) { }

      
        public DbSet<Cliente> Clientes { get; set; }
        public DbSet<Cadastro> Cadastros { get; set; }
        public DbSet<Viagem> Viagens { get; set; }
        public DbSet<Reserva> Reservas { get; set; }


    }
}
