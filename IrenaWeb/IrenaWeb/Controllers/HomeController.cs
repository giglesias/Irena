namespace IrenaWeb.Controllers
{
    using IrenaWeb.Helpers;
    using IrenaWeb.Models;
    using System.Web.Mvc;

    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Create(HistoriaClinica medicalHistory)
        {
            var medicalHistoryQrCode = medicalHistory.GenerateRelayQrCode();
            ViewBag.qrCode = medicalHistoryQrCode;
            return View("~/Views/Home/Report.cshtml");
        }
    }
}
