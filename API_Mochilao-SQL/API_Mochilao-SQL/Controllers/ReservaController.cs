using API_Mochilao_SQL.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace API_Mochilao_SQL.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ReservaController : ControllerBase
    {
        private readonly MochilaoDbContext _context;

        public ReservaController(MochilaoDbContext context)
        {
            _context = context;
        }

        [HttpGet]
        public IEnumerable<Reserva> GetReservas()
        {
            return _context.Reservas;
        }

        [HttpGet("{id}")]
        public IActionResult GetReservaPorId(int id)
        {
            Reserva reserva = _context.Reservas.SingleOrDefault(modelo => modelo.id_reserva == id);
            if (reserva == null)
            {
                return NotFound();
            }
            return new ObjectResult(reserva);
        }

        [HttpPost]
        public IActionResult CriarReserva(Reserva item)
        {
            if (item == null)
            {
                return BadRequest();
            }

            _context.Reservas.Add(item);
            _context.SaveChanges();
            return new ObjectResult(item);
        }

        [HttpPut("{id}")]
        public IActionResult AtualizaReserva(int id, Reserva item)
        {
            if (id != item.id_reserva)
            {
                return BadRequest();
            }
            _context.Entry(item).State = EntityState.Modified;
            _context.SaveChanges();

            return new NoContentResult();
        }

        [HttpDelete("{id}")]
        public IActionResult DeletaReserva(int id)
        {
            var reserva = _context.Reservas.SingleOrDefault(m => m.id_reserva == id);

            if (reserva == null)
            {
                return BadRequest();
            }

            _context.Reservas.Remove(reserva);
            _context.SaveChanges();
            return Ok(reserva);
        }

    }


}

