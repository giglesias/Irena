namespace IrenaWeb.Controllers
{
    using System;
    using System.Web.Mvc;

    using IrenaWeb.Models;
    using IrenaWeb.Services;

    public class HomeController : Controller
    {
        private readonly QrCodeService qrCodeService;

        public HomeController()
            : this(new QrCodeService())
        {
        }

        public HomeController(QrCodeService qrCodeService)
        {
            if (qrCodeService == null)
            {
                throw new ArgumentNullException("qrCodeService");
            }

            this.qrCodeService = qrCodeService;
        }

        public ActionResult Index()
        {
            return this.View();
        }

        public ActionResult Create()
        {
            return this.View();
        }

        [HttpPost]
        public ActionResult Create(HistoriaClinica medicalHistory)
        {
            var medicalHistoryQrCode = this.qrCodeService.GenerateRelayQrCode(medicalHistory);
            ViewBag.qrCode = medicalHistoryQrCode;
            return this.View("~/Views/Home/Report.cshtml");
        }
    }
}
